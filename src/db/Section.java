package db;

public class Section extends NewDBManager {

	public Section getSection(Section section, boolean needsMachines)throws Exception{
		Section sect1=new Section();
		sql=
	}
	
	public Section getSection(Section section)throws Exception{
		getSection(section,true);
	}
	
}
