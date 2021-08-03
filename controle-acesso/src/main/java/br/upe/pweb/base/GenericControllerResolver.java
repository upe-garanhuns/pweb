package br.upe.pweb.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class GenericControllerResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterAnnotation(GenericController.class) != null;
  }

  @SuppressWarnings("rawtypes")
  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    
    String tipo = "";
    
    for (Type genericInterface : getClass().getGenericInterfaces()) {
        if (genericInterface instanceof ParameterizedType) {
            Type[] genericTypes = ((ParameterizedType) genericInterface).getActualTypeArguments();
            tipo = ((Class) genericTypes[0]).getSimpleName().toLowerCase();
        }
    }
    
    return tipo;
  }

}
