
public class Action {

	
	public Integer damageBonus;
	public String damageDice;
	public Integer attackBonus;
	public String desc;
	public String name;
	public boolean isLegendary = false;
	
	public Action(Integer damageBonus, String damageDice, Integer attackBonus, String desc, String name, Boolean isLegendary) {
		this.damageBonus = damageBonus;
		this.damageDice = damageDice;
		this.attackBonus = attackBonus;
		this.desc = desc;
		this. name = name;
		this.isLegendary = isLegendary;
	}
	
}
