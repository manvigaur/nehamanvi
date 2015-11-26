<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<BODY>

	<center>
		<font face="Arial" size="4"> <b>Queue Implementation</b>
		</font> <br> </br> </br>
		<Table CELLSPACING="4" bgcolor="White" CELLPADDING="0" BORDER="1">
			<TR>
				<TD ALIGN="center" bgcolor="White"><applet
						code="com.queue.QueueApplet" archive="DataStructureAlgo.jar"
						width="440" height="500" /></applet>
				<TD>
<TD ALIGN="Left">
					<p>
						<br> <font face="Arial" size="2" color="Brown"><u><b>Help</b></u>
						</font><br> <font face="Arial" size="2" color="black">This
							demo demonstrates the basic operations on a Queue data
							structure. In Queue insert is done at rear end and delete is done from front end. 
							<br>
							<br>
							<br>
							<b>Function Discription :</b>
							<ul>
							<li><b>New</b>: Creates new empty Queue</li>
								<li><b>Insert</b>: Inserts  element at rear end into the Queue. This
									applet inserts a randomly generated value between 0 to 99 , when the "Insert"
									button is clicked.</li>
								<li><b>Delete</b>: Deletes an element from the front of Queue.</li>
								<li><b>Front</b>: Display front-element value  the Queue.</li>
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
