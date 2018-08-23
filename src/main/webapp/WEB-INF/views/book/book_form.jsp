<form:hidden path="id"/>
Title:
<form:input path="title"/><form:errors path="title" cssClass="classError" /><br/>
Description:
<form:input path="description"/><br/>
Publisher:
<form:select itemLabel="firstName" path="publisher" items="${publishers}" /><br/>
