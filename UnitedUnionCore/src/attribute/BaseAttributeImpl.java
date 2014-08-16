package attribute;

public class BaseAttributeImpl<CodeType> implements BaseAttribute<CodeType>{
	private CodeType code;
	
	private final String name;
	
	public BaseAttributeImpl(String name,  CodeType code) {
		this.name=name;
		this.code=code;
		
	}
	
	@Override
	public String getName() {
		return name;
		
	}

	@Override
	public BaseAttribute<CodeType> clone() {
		return null;
		
	}
	
	@Override
	public CodeType getCode() {
		return this.code;
		
	}
	
	public void setCode(CodeType code) {
		this.code=code;
		
	}
}
