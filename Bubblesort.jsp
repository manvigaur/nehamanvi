<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<BODY>

	<center>
		<font face="Arial" size="4"> <b>Bubble Sort Implementation</b>
		</font> <br> </br> </br>
		<Table CELLSPACING="4" bgcolor="White" CELLPADDING="0" BORDER="1">
			<TR>
				<TD ALIGN="center" bgcolor="White"><applet
						code="com.sort.bubble.BubbleSortApplet" archive="DataStructureAlgo.jar"
						width="440" height="500" /></applet>
				<TD>
<TD ALIGN="Left">
					<p>
						<br> <font face="Arial" size="2" color="Brown"><u><b>Help</b></u>
						</font><br> <font face="Arial" size="2" color="black">This
							demo demonstrates the basic operations of Bubble Sort Algo.Bubble sort is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares each pair of adjacent items and swaps them if they are in the wrong order 
							<br>
							<br>
							<br>
							<b>Function Discription :</b>
							<ul>
							<li><b>New</b>: Creates new array of size 10 with random values from 1 to 199 .</li>
								<li><b>Run</b>: Causes all sorting steps to be automatically executed </li>
								<li><b>Step</b>: User can click "step" button to go step by step</li>
							</ul>
						</font>
					<p>
				</TD>

			</TR>
		</Table>
	</center>

	<br>
	</br>
	</br>
	<jsp:include page="footer.jsp"></jsp:include>
</BODY>
</HTML>
