package com.example.test.controller;

import com.example.test.entity.Test;
import com.example.test.form.TestForm;
import com.example.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestService service;

    @ModelAttribute
    public TestForm setUpForm() {
        TestForm form = new TestForm();
        //라디오 버튼의 초깃값 설정
        form.setAnswer(true);
        return form;
    }

    //Test 목록 표시
    @GetMapping
    private String showList(TestForm testForm, Model model) {
        //신규 등록 설정(요부분)
        testForm.setNewTest(true);
        //퀴즈 목록 취득
        Iterable<Test> list = service.selectAll();
        //표시용 Model에 저장
        model.addAttribute("list", list);
        model.addAttribute("title","등록 폼");
        return "crud";
    }

    @PostMapping("/insert")
    public String insert(@Validated TestForm testForm, BindingResult bindingResult,
                         Model model, RedirectAttributes redirectAttributes){
        // Form에서 Entity로 넣기
        Test test = new Test();
        test.setQuestion(testForm.getQuestion());
        test.setAnswer(testForm.getAnswer());
        test.setAuthor(testForm.getAuthor());

        // 입력 체크
        if (!bindingResult.hasErrors()) {
            service.insertTest(test);
            redirectAttributes.addFlashAttribute("complete", "등록이 완료되었습니다");
            return "redirect:/test";
        } else {
            // 에러가 발생한 경우에는 목록 표시로 변경
            return showList(testForm, model);
        }

    }

}
