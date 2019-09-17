package interfaces;

public interface IDAO {

	public void add(IEntity pEntity);
	
	public void update(IEntity pEntity);
	
	public void removeByPrimaryKey(IEntity pEntity, Object pPrimaryKey);
	
	public void removeByObject(IEntity pEntity);
	
	public IEntity listByPrimaryKey(Class pClass, Object pPrimaryKey);
	
	public IEntity listByObject(IEntity pEntity);

}
