package M1_T08_P30;

import M1_T08_P30.ITeam.LANGUAGE;

public class Team {
	
	protected String name = null;
	protected String school = null;
	protected LANGUAGE langauge = null;
	protected int nMembers = 0;
	protected Member[] lMembers = null;
	
	public Team(String name, String school, LANGUAGE langauge) {
		super();
		this.name = name;
		this.school = school;
		this.langauge = langauge;
		this.nMembers = 0;
		this.lMembers = new Member[ITeam.MAX];
	}
	
	public boolean lMembersEmpaty() {
		return (lMembers==null || nMembers == 0);	
	}
	
}
