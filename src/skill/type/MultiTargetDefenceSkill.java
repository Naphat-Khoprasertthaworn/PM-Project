package skill.type;

import java.util.ArrayList;

import entity.base.Buff;
import entity.base.Unit;

public class MultiTargetDefenceSkill extends DefenceSkill {

	public MultiTargetDefenceSkill(String name, String text, int ratio, int cd) {
		super(name, text, ratio, cd);
	}

	@Override
	public void skillEffect(ArrayList<Unit> units, int targetUnit, Unit owner) {
		for(Unit unit:units) {
			unit.receiveHeal( (this.getRatio()*owner.getTotalAttack())/100 );
			for(Buff b: this.getBuffsTarget()) {
				unit.addBuff(b);
			}
			for(Buff b:this.getBuffsSelf()) {
				owner.addBuff(b);
			}
		}
		
	}

}
