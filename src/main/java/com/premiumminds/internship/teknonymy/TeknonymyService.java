package com.premiumminds.internship.teknonymy;

import java.time.LocalDateTime;

import com.premiumminds.internship.teknonymy.Person;

class TeknonymyService implements ITeknonymyService {
	
	private int globalDepth = 0;
    private Person oldestChild = null;
  /**
   * Method to get a Person Teknonymy Name
   * 
   * @param Person person
   * @return String which is the Teknonymy Name 
   */
  public String getTeknonymy(Person person) {

    dfs(person, 0);    
    
    StringBuilder sb = new StringBuilder();
    if(globalDepth == 0) {
    	return "";
	} else {
		Character sex = person.sex();
		for (int i = globalDepth; i > 0; i--) {
			if(i == 1) {
				if(sex.equals('M')) {
					sb.append("father of " + oldestChild.name());
				} else {
					sb.append("mother of " + oldestChild.name());
				}
			} else if (i == 2) {
				sb.append("grand");
			} else {
				sb.append("great-");
			}
		}
	}
//    System.out.println(globalDepth);
//    System.out.println(sb.toString());
    return sb.toString();
  };
  
 

  private void dfs(Person person, int depth) {
      // Base case: leaf node
      if (person.children() == null) {
          if (depth > globalDepth) {
        	  globalDepth = depth;
        	  oldestChild = person;
          }
          else if(depth == globalDepth) {
        	  if (oldestChild == null) {
        		  oldestChild = person;
        	  } else if(isOlder(person, oldestChild)) {
        		  oldestChild =  person;
        	  }
          }
          return;
      }

      for (Person child : person.children()) {
          dfs(child, depth + 1); 
      }

  }



	private boolean isOlder(Person person, Person oldestChild2) {
		LocalDateTime birthDate1 = person.dateOfBirth();
        LocalDateTime birthDate2 = oldestChild2.dateOfBirth();

        return birthDate1.isBefore(birthDate2);
	}
}