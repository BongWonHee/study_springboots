<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Menu -->
<sec:authentication property="principal" var="userDetailsBean" />
<form>
    <nav class="navbar navbar-expand-lg bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">Logo</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <button class="nav-link" formaction="/home">Home</button>
                    </li>
                    <li class="nav-item">
                        <button class="nav-link" formaction="/carInfor/map/selectSearch">Carinfo List</button>
                    </li>
                    <li class="nav-item">
                        <button class="nav-link" formaction="/files/formMulti">formMulti</button>
                    </li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item">
                        <button class="nav-link" formaction="/admin">Admin</button>
                    </li>
                    </sec:authorize>   
                    <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')">
                        <li class="nav-item">
                            <button class="nav-link" formaction="/manager/read">Manager/read</button>
                        </li>
                    </sec:authorize>                                     
                </ul>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <%-- 로그인이 필요한 상태 --%>
                <sec:authorize access="isAnonymous()">
           
                <li>
                    <button class="nav-link" formaction="/joinForm">joinForm</button>
                </li>
                <li>
                    <button class="nav-link" formaction="/loginForm">login Form</button>
                </li>
                </sec:authorize>
                <%-- 로그인이 된 상태 --%>
                <sec:authorize access="isAuthenticated()">
                <li class="nav-link">
                    ID : ${userDetailsBean.username}, Name : ${userDetailsBean.memberName}, 
                </li>
                <li>
                    <button class="nav-link" formaction="/logoutForm">logout Form</button>
                </li>
                </sec:authorize>
            </ul>
        </div>
    </nav>
</form>