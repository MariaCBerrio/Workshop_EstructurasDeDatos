import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
//		Creación de la pila
		Stack<HtmlTag> tagStack = new Stack<>();
		for (HtmlTag tag: tags) {

//			Si es una etiqueta de apertura
			if (tag.isOpenTag()) {
				tagStack.add(tag);

//			  Sino, si es una etiqueta de cierre y no de autocerrado
			} else if (!tag.isSelfClosing()){

//				Si la pila no está vacía y la última etiqueta de apertura agregada coincide con la etiqueta de cierre
				if (!tagStack.isEmpty() && tag.matches(tagStack.peek())) {
//					Elimina de la pila la última etiqueta agregada
					tagStack.pop();

//				  Sino, si la lista está vacía
				} else if (tagStack.isEmpty()) {
					return null;
				} else {
					return tagStack;
				}
			}
		}
		return tagStack;
	}
}

