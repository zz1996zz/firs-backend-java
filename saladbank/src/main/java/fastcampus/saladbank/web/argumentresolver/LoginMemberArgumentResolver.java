package fastcampus.saladbank.web.argumentresolver;

import fastcampus.saladbank.config.auth.PrincipalDetails;
import fastcampus.saladbank.web.dto.MemberForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean hasMemberFormType = MemberForm.class.isAssignableFrom(parameter.getParameterType());

        return hasLoginAnnotation && hasMemberFormType;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
            MemberForm memberForm = new MemberForm();
            memberForm.setUsername(principal.getUsername());
            return memberForm;
        }
        return null;
    }
}
