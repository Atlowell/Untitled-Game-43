import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;


public class CustomOutputStream extends OutputStream {

	private JTextArea text;
	
	public CustomOutputStream(JTextArea t) {
		text = t;
	}
	
	@Override
	public void write(int i) throws IOException {
		text.append(String.valueOf((char)i));
		text.setCaretPosition(text.getDocument().getLength());
	}

	public JTextArea getText() {
		return text;
	}

}
