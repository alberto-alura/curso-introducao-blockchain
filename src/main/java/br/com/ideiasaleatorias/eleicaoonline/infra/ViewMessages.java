package br.com.ideiasaleatorias.eleicaoonline.infra;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Quando quiser adicionar mensagens na pagina através de atributos do request.
 * @author alberto
 *
 */
public class ViewMessages {

	private static final String ERROR_MESSAGE = "errorMessage";

	public static void errorFlash(String message,RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute(ERROR_MESSAGE, message);
	}
	
	public static void successFlash(String message,RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("successMessage", message);
	}

	public static void error(String message, ModelAndView modelAndView) {
		modelAndView.addObject(ERROR_MESSAGE,message);
	}
	public static void error(String message, Model model) {
		model.addAttribute(ERROR_MESSAGE,message);
	}
}
