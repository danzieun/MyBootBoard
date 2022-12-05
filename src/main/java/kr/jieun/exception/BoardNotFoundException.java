package kr.jieun.exception;

public class BoardNotFoundException extends BoardException {

	private static final long serialVersionUID = 1789463125463L;

	public BoardNotFoundException(String message) {
		super(message);
	}

}
