<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"></jsp:include>

<BODY>

	<center>
		<font face="Arial" size="4"> <b>Stack Implementation</b>
		</font> <br> </br> </br>
		<Table CELLSPACING="4" bgcolor="White" CELLPADDING="0" BORDER="1">
			<TR>
				<TD ALIGN="center" bgcolor="White"><applet
						code="com.stack.StackApplet" archive="DataStructureAlgo.jar"
						width="440" height="500" /></applet>
				<TD>
<TD ALIGN="Left">
					<p>
						<br> <font face="Arial" size="2" color="Brown"><u><b>Help</b></u>
						</font><br> <font face="Arial" size="2" color="black">This
							demo demonstrates the basic operations on a stack data
							structure. Push is used to enter element at the top of stack & Pop is used to remove element from top of the stack.
							<br>
							<br>
							<br>
							<b>Function Discription :</b>
							<ul>
							<li><b>Reset</b>: Creates new empty stack</li>
								<li><b>Push</b>: Inserts an element into the stack. This
									applet inserts a randomly generated value between 0 to 99 , when the "Push"
									button is clicked.</li>
								<li><b>Pop</b>: Deletes an elament from the top of stack.</li>
								<li><b>Top</b>: Reads the value at the top of stack.</li>
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
