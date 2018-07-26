<%@taglib uri="/struts-tags" prefix="html" %>
<html:form action="student">
<html:textfield name="sno" label="StudentNo"></html:textfield>
<html:textfield name="sname" label="StudentName"></html:textfield>
<html:textfield name="sadd" label="StudentAddress"></html:textfield>
<html:submit value="insert"></html:submit>
</html:form>