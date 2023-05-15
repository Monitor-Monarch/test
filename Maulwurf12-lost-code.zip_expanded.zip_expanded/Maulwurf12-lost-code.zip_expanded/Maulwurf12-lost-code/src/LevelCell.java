import enums.State;

public class LevelCell {

	private State status;

	public LevelCell() {
		this(State.empty);
	}

	public LevelCell(State status){
		this.status = status;
	}
	public State getStatus() {
		return this.status;
	}

	/*public boolean mayMoveInto() {
		return getStatus() != State.wall;
	}*/

	public static int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

}