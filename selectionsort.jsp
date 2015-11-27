<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<BODY>

	<center>
		<font face="Arial" size="4"> <b>Selection Sort Implementation</b>
		</font> <br> </br> </br>
		<Table CELLSPACING="4" bgcolor="White" CELLPADDING="0" BORDER="1">
			<TR>
				<TD ALIGN="center" bgcolor="White"><applet
						code="com.sort.selection.SelectSortApplet" archive="DataStructureAlgo.jar"
						width="440" height="500" /></applet>
				<TD>
<TD ALIGN="Left">
					<p>
						<br> <font face="Arial" size="2" color="Brown"><u><b>Help</b></u>
						</font><br> <font face="Arial" size="2" color="black">This
							demo demonstrates the basic operations of Selection Sort Algo.It starts by comparing the entire list for the lowest item and moves it to the #1 position. It then compares the rest of the list for the next-lowest item and places it in the #2 position and so on until all items are in the required order.. 
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
