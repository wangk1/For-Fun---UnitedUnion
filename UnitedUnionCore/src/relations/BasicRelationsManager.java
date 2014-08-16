package relations;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import annotations.Relation;
import annotations.Relation.RelationType;

/**
 * Vanilla relations implementation
 * 
 * @author wangk1
 *
 * @param <Key>
 */
public class BasicRelationsManager<Key> implements RelationsManager<Key>{
	private RelationType[] type;
	private boolean isBidirectional;
	

	private Map<Key,List<Relations<? extends Key>>> relationMapping;

	public BasicRelationsManager(Class<?> classOfRelation) {
		type=classOfRelation.getAnnotation(Relation.class).value();		
		isBidirectional=classOfRelation.getAnnotation(Relation.class).bidirectional();

		relationMapping=new HashMap<Key,List<Relations<? extends Key>>>();

	}


	@Override
	public boolean relationExists(Relations<? extends Key> relations, Relations<? extends Key> relationsTarget) {
		return testOnetoOneRelation(relations,relationsTarget);
		
	}

	//Tests if one to one relation exists between relationsFrom to relationsTarget
	private boolean testOnetoOneRelation(Relations<? extends Key> relationFrom, Relations<? extends Key> relationsTarget) {
		//Bidirectional 1 to 1 relations detector
		if(isBidirectional) {
			boolean useRelation1Store=true;

			//temp relations store
			List<Relations<? extends Key>> tempRelationsList=relationMapping.get(relationFrom.getKey());

			//if null, then the relation is stored in relationsTarget's list
			if(tempRelationsList==null) {
				tempRelationsList=relationMapping.get(relationsTarget.getKey());

				useRelation1Store=false;
			}

			//None exists if both lists are null
			if(tempRelationsList != null) {

				//since the relationship store exists, does the store contain the relation?
				return tempRelationsList.contains(
						useRelation1Store? relationsTarget.getKey():relationFrom.getKey());

			}

		} else {



		}

		return false;
	}


	/**
	 * One to one relation mapping
	 * 
	 */
	@Override
	public void createRelations(Relations relationsFrom,
			Relations relationsTarget) {
		// TODO Auto-generated method stub

	}


	/**
	 * Many to one relation
	 * 
	 */
	@Override
	@Deprecated
	public void createRelations(Collection<? extends Relations> relationsFrom,
			Relations relationsTarget) {
		// TODO Auto-generated method stub

	}

	/**
	 * One to Many Relation
	 * 
	 */
	@Deprecated
	@Override
	public void createRelations(Relations relationsFrom,
			Collection<? extends Relations> relationsTarget) {
		// TODO Auto-generated method stub

	}

	/**
	 * Many to many relation
	 * 
	 */
	@Deprecated
	@Override
	public void createRelations(Collection<? extends Relations> relationsFrom,
			Collection<? extends Relations> relationsTarget) {
		// TODO Auto-generated method stub

	}




}
