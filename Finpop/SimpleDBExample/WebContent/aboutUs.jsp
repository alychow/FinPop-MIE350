<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="style/results.css">
<link rel="stylesheet" type="text/css" href="style/aboutUs.css">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>About Us</title>
</head>
<body>
<% String login = request.getParameter("login"); 
	
		Cookie[] cookies = request.getCookies();

		// Check if the user logged in is the same as the one being viewed
		String storedLogin = null;
		for(Cookie cookie : cookies){
		    if("loginCookie".equals(cookie.getName())){
		        storedLogin = cookie.getValue();
		    }
		}
		if (storedLogin!=(null)){

			%>
			<div id="container">
				<a href="search.jsp"><img id="logo" src="img/logo.png"></img></a>
				<form id="search_form" method="POST" action='SearchController' name="DynamicSearch">
					<input id="search_bar" type="text" name="keyword"
						value="" placeholder="Search Company or Hedgefund">
						<input id="submit_button" type="submit" value="Search" />
				</form>	
					<div id="menu">					
					<a href="resources.jsp">Resource</a>	
					<a href="aboutUs.jsp">About Us</a>						
					<a href="editUser.jsp">My Account</a>
					<a href="PortfolioController?action=listPortfolio&userId=<%out.print(storedLogin);%>"><%out.print(storedLogin);%>'s Portfolio</a>
					<a href="deleteCookie.jsp">Logout</a></div>
			</div>
<div class="page">
<img id="team-image" src="img/team.png"/>
<p><strong>Summary of Functionalities</strong></p>
<p>FinPOP strives to solve the problem of non-institutional investors struggling with investment decisions by providing management tool to track their investments through a direct feed of hedge fund activity. In particular, we provide a search system that displays prominent hedge fund information and the companies that they current have a stake in. User&rsquo;s can signup and create an account through FinPOP to receive access to the search, where they are able to find hedge funds and the companies that they invest in. By default, new users have one portfolio and can save company shares to their portfolio based on their investment preferences. In this portfolio, users are able to edit the number of shares that they have in a company, and remove companies that they no longer wish to invest in.</p>
<p>&nbsp;</p>
<p><strong>Description of FinPOP Team and Task Context </strong></p>
<p>A team of six industrial engineering students at the University of Toronto have developed FinPOP for a course called Design and Analysis of Information Systems (MIE350). The team consists a project manager (Alison Chow), a backend developer (Alex Walmsley), a frontend developer (Raymond Chou), a user interface and experience designer (Ana Medinac), a researcher (Aidan Jappy), and a documentation writer (Victor Denisov). The FinPOP team believes in open source projects. You can find the complete codebase on FinPOP&rsquo;s official Github repository here: <a href="https://github.com/alychow/FinPop-MIE350. ">https://github.com/alychow/FinPop-MIE350. </a></p>
<p>&nbsp;</p>
<p><strong>Textual Information of topic area </strong></p>
<p>Hedge funds are large financial institutions that group investor&rsquo;s money and invest this capital into mutual funds, stocks, and other financial instruments in efforts to yield a positive return[1]. Typically, hedge funds have more flexibly strategies than the current market, which proves to be very effective as many of these hedge funds reap large returns at the end of the financial year. FinPOP derives it&rsquo;s value proposition by providing relevant information from hedge fund investment activity to users who wish to base their decisions off these successful hedge funds. [1] Investor Bulletin, Hedge Funds. (December 6, 2016).</p>
<p>Available: <a href="https://www.sec.gov/investor/alerts/ib_hedgefunds.pdf">https://www.sec.gov/investor/alerts/ib_hedgefunds.pdf</a></p>
<p><strong>Summary of Functionalities</strong></p>
<p>FinPOP strives to solve the problem of non-institutional investors struggling with investment decisions by providing management tool to track their investments through a direct feed of hedge fund activity. In particular, we provide a search system that displays prominent hedge fund information and the companies that they current have a stake in. User&rsquo;s can signup and create an account through FinPOP to receive access to the search, where they are able to find hedge funds and the companies that they invest in. By default, new users have one portfolio and can save company shares to their portfolio based on their investment preferences. In this portfolio, users are able to edit the number of shares that they have in a company, and remove companies that they no longer wish to invest in.</p>
<p>&nbsp;</p>
<p><strong>Description of FinPOP Team and Task Context </strong></p>
<p>A team of six industrial engineering students at the University of Toronto have developed FinPOP for a course called Design and Analysis of Information Systems (MIE350). The team consists a project manager (Alison Chow), a backend developer (Alex Walmsley), a frontend developer (Raymond Chou), a user interface and experience designer (Ana Medinac), a researcher (Aidan Jappy), and a documentation writer (Victor Denisov). The FinPOP team believes in open source projects. You can find the complete codebase on FinPOP&rsquo;s official Github repository here: <a href="https://github.com/alychow/FinPop-MIE350. ">https://github.com/alychow/FinPop-MIE350. </a></p>
<p>&nbsp;</p>
<p><strong>Textual Information of topic area </strong></p>
<p>Hedge funds are large financial institutions that group investor&rsquo;s money and invest this capital into mutual funds, stocks, and other financial instruments in efforts to yield a positive return[1]. Typically, hedge funds have more flexibly strategies than the current market, which proves to be very effective as many of these hedge funds reap large returns at the end of the financial year. FinPOP derives it&rsquo;s value proposition by providing relevant information from hedge fund investment activity to users who wish to base their decisions off these successful hedge funds. [1] Investor Bulletin, Hedge Funds. (December 6, 2016).</p>
<p>Available: <a href="https://www.sec.gov/investor/alerts/ib_hedgefunds.pdf">https://www.sec.gov/investor/alerts/ib_hedgefunds.pdf</a></p>
<p>&nbsp;</p>


<p><strong>DISCLAIMER</strong><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">This legal notice governs your use of this website. Please read it carefully. By accessing this website, you acknowledge and agree to the following. If you do not agree, please log off this website immediately.</span></p>
<p><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">You are currently accessing the official corporate Internet website (the &ldquo;website&rdquo;) of FinPOP. &nbsp;Services are provided by FinPOP only in such jurisdictions and to such customers as permitted by local law. FinPOP may, from time to time, change the rules that govern your use of this website. FinPOP shall have the right at any time, without providing individual notice, to change, modify, add, or delete the terms and conditions applicable to your use of the website or any part thereof. Any changed terms shall be effective immediately upon notice thereof, which may be given by any means including, but not limited to, posting the changed terms on the website, by electronic or conventional mail, or by any other means by which you obtain notice thereof. Any use of the website by you after such notice shall be deemed to constitute acceptance by you of the changed terms.</span></p>
<p><span style="font-weight: 400;"><br /></span><strong>Disclaimer Regarding the Products and Services Presented on the Website</strong><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">No information appearing on this website shall be deemed as an offer of services or products from FinPOP or as an offer to purchase or sell or as the solicitation of an offer to purchase or sell securities, futures, options, or any other investment product. FinPOP disclaims all liabilities regarding the content of these pages and any use thereof that could be made by any person.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">Neither FinPOP nor the other providers of data on this website make any representations or warranties, express or implied, as to the accuracy, completeness, or fitness for any purpose or use of the content provided. Further, FinPOP disclaims any implied warranty of merchantability or non-infringement. The contents of this website are provided on an &ldquo;as is&rdquo; or &ldquo;as available&rdquo; basis and may not be current in all cases. The information on this website is subject to continuous change, and FinPOP assumes no responsibility to update or amend such information. Accordingly, you should not rely on any of the information as authoritative or as a substitute for the exercise of your own skill and judgment in making an investment or other decision.</span></p>
<p><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">YOU ACKNOWLEDGE, BY YOUR USE OF THE WEBSITE, THAT YOUR USE OF THE WEBSITE IS AT YOUR SOLE RISK, THAT YOU ASSUME FULL RESPONSIBILITY FOR ALL COSTS ASSOCIATED WITH YOUR USE OF OUR WEBSITE, AND THAT BRIGHTWORK SHALL NOT BE LIABLE FOR ANY DAMAGES OF ANY KIND RELATED TO YOUR USE OF THIS WEBSITE.</span></p>
<p><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">Although FinPOP makes all reasonable efforts to ensure it receives information from sources it deems reliable, fair, and accurate, FinPOP does not claim that all information or opinions presented on its website are true, reliable, or complete. The information and opinions included on this website are supplied by FinPOP for informational and personal use only and they may be modified without prior notice. Information appearing on this website does not constitute, in any way, investment, legal, tax, or any other advice. It may not be considered as grounds for an investment or other decision.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">You agree to defend, indemnify, and hold FinPOP, its subsidiaries, affiliates, successors, assigns, and their respective shareholders, directors, officers, employees, and agents harmless from and against any and all claims, damages, costs, and expenses, including attorneys&rsquo; fees, arising from or related to your use of the website.</span></p>
<p><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">FinPOP SHALL NOT BE LIABLE FOR INDIRECT, INCIDENTAL, CONSEQUENTIAL, RELIANCE OR SPECIAL DAMAGES FOR HARM TO BUSINESS, LOST PROFITS, LOST SAVINGS, OR LOST REVENUES, WHETHER OR NOT FINPOP HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. FINPOP SHALL NOT BE LIABLE FOR ANY DAMAGE THAT ANY USER MAY SUFFER ARISING OUT OF THE USE OF; OR THE INABILITY TO USE, SERVICES OR CONTENT PROVIDED HEREUNDER. THESE LIMITATIONS OF LIABILITY SHALL APPLY REGARDLESS OF THE FORM OF ACTION, WHETHER IN CONTRACT OR TORT, AND SHALL SURVIVE FAILURE OF AN EXCLUSIVE REMEDY.</span></p>
<p><span style="font-weight: 400;"><br /></span><strong>Jurisdiction</strong><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">Information contained herein is not intended to be published or made available to any person in any jurisdiction where doing so would result in contravention of any applicable laws or regulations. Access to the products and services described herein may be subject to restrictions vis-&agrave;-vis certain persons or in certain countries. None of the products or services presented herein shall be supplied by FinPOP to a person in the event that the law of his/her country of origin, or any other country concerning him/her, prohibits it. The reader of this message should ensure that he/she is legally authorized to access this website in the country or territory from where the access is gained. Accordingly, if it is prohibited to make such information available in your jurisdiction or to you (by reason of your nationality, residence, or otherwise), this information is not directed at you. Before reviewing the pages of our website, you must be satisfied that doing so will not result in such a contravention and is not prohibited.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">These terms and conditions shall be governed and construed in accordance with the laws of the Province of Ontario without giving effect to the conflict of laws principles thereof. The courts of the Province of Ontario, in the city of Toronto, shall have exclusive jurisdiction in respect to any dispute that may arise hereunder.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">In the event that any of the terms or conditions of use of this site are held to be invalid or unenforceable, the invalid or unenforceable portions shall be severed from the remaining terms and conditions, which shall continue to be enforceable to the fullest extent permitted by applicable law.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">Links</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">Please be aware that FinPOP has no control or liability regarding any links or the creation of any links to other sites external to FInPOP and regarding the content of said sites. Therefore, you accept that your choice to access another site through a hypertext link is made under your own responsibility, and FinPOP shall not be liable for any damages that result, directly or indirectly, from your access to another site connected by a hypertext link. Because the materials made available on these sites are not under the control of FinPOP, we make no representation about these sites or the materials that may be included therein. The fact that FinPOP has linked to these sites does not constitute an endorsement or recommendation of any kind. These links are provided only as a convenience.</span></p>
<p><span style="font-weight: 400;"><br /></span><strong>Intellectual Property</strong><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">FinPOP and any other names, images, and logos identifying FinPOP and its products and services are proprietary trademarks of FinPOP. FinPOP does not permit the use of its name in advertising, as an endorsement of any product or service, or for any other commercial purpose, except where expressly permitted by written agreement between parties.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">You may view, print, download, or store temporarily extracts from this website without alteration, addition, or deletion for the purposes only of your own reference. If you download information or software from this website, you agree that you will not copy, remove, or obscure any copyright or other notices or legends contained in any such information. Except as otherwise provided in this paragraph; neither this website nor any part of it may be otherwise copied, reproduced, distributed, or transmitted in any media (including, without limitation, via any other website) without the written permission of FinPOP. No other use of the information or materials contained on this website is permitted. All rights reserved.</span><span style="font-weight: 400;"><br /></span><span style="font-weight: 400;">This website and the copyright in the materials on this website (including all text, information, graphics, animation, and images) is owned by or licensed to FinPOP.</span></p>
<p>&nbsp;</p>
</div>
</body>
      <script src="js/search.js"></script>

<%
		} else {
			%><a id="login_button" href="index.jsp">Login</a><%
			out.print("You are NOT allowed to view private data for " + login + ".");
		}
	%>
</html>