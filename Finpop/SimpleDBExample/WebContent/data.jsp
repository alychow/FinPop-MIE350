<%@ page import='java.util.*' %>

<% 

	Map users = new HashMap<String,String[]>();
	// add data records 
	// record schema: id, [login, password, name, position, company, city, country]
	users.put("kathleen", 	new String[] {"kathleen", "abc", "Kathleen Wynne", "Premier of Ontario", "Liberal Government of Canada", "Toronto, Ontario", "CA"});
	users.put("john", 		new String[] {"john", 	  "123", "John Tory", "Mayor", "City of Toronto", "Toronto, Ontario", "CA"});
	users.put("fatima", 	new String[] {"fatima",   "ABC", "Fatima Bhutto", "Poet", "Self-employed", "Kabul", "AP"});
	users.put("tim", 		new String[] {"tim", 	  "321", "Tim Cook", "CEO", "Apple", "Palo Alo, California", "USA"});	



	Set<String> keysS = users.keySet();
	String[] keys = keysS.toArray(new String[keysS.size()]);

%>