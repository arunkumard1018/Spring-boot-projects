<%@ include file="comman/header.jspf"%>
<title>welcome</title>
</head>

<body>
	<%@ include file="comman/index-nav.jspf"%>
	<div class="container w-25 mt-5">
		<div class="form-signin text-center">
			<form:form action="/register" method="POST" modelAttribute="user">
				<!-- <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
				<h1 class="h3 mb-3 fw-normal">Please register to Sign in</h1>

				<div class="form-floating">
					<form:input path="name" class="form-control" id="floatingInput"
						placeholder="Full Name"></form:input>
					<label for="floatingInput">Name</label>
				</div>
				<div class="form-floating">
					
					<form:input path="email" class="form-control" id="floatingInput"
						placeholder="name@example.com"></form:input>
					<label for="floatingInput">Email address</label>
                    
				</div>
				<div class="form-floating">
					
					<form:input path="password" class="form-control"
						id="floatingPassword" placeholder="Password"></form:input>
					<label for="floatingPassword">Password</label>
				</div>

				<div class="checkbox mb-3">
					<label> already have an account ? <a href="/login">Sign
							in</a>
					</label>
                    
				</div>
				<button class="w-100 btn btn-lg btn-primary" type="submit">Register</button>
                <div class="text-danger my-1"><form:errors path="name" class="text-danger" for="floatingInput"/></div>
                <div class="text-danger my-1"><form:errors path="email" class="text-danger" for="floatingInput"/></div>
                <div class="text-danger my-1"><form:errors path="password" class="text-danger" for="floatingInput"/></div>
				<p class="mt-5 mb-3 text-muted">&copy; 2022–2023</p>
			</form:form>
		</div>
	</div>
	<script>
		document.getElementById("#reg-btn").remove()
	</script>