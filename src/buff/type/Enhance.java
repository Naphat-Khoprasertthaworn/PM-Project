package buff.type;


import entity.base.Buff;
import entity.base.Unit;

public class Enhance extends Buff{

	private int increasingAttack;
	//private final String imagePath = "image/enhanceBuff.png";
	public Enhance(int turn,int ratio) {
		super(turn, ratio);
		super.setName("Enhance");
	}
	
	public Enhance(Enhance e) {
		this(e.getTurn(), e.getRatio());
	}
	
	@Override
	public void activeBuff(Unit unit) {
		
		this.setIncreasingAttack(unit.getAttack());
		unit.setBuffAttack( unit.getBuffAttack() + this.getIncreasingAttack() );
		
	}
	@Override
	public void removeSelf(Unit unit) {
		unit.setBuffAttack( unit.getBuffAttack() - this.getIncreasingAttack() );
	}

	public int getIncreasingAttack() {
		return increasingAttack;
	}

	public void setIncreasingAttack(int baseAttack) {
		this.increasingAttack = ( baseAttack*this.getRatio() )/100 ;
	}
	
	
}
