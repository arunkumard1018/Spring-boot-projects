<%@ include file="comman/header.jspf" %>
    <title>welcome</title>
    </head>

    <body>
        <%@ include file="comman/index-nav.jspf" %>
            <div class="container w-25 mt-5">
                <div class="form-signin text-center">
                    <form action="/login" method="POST">
                        <!-- <img class="mb-4" src="../assets/brand/bootstrap-logo.svg" alt="" width="72" height="57"> -->
                        <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                        <div class="form-floating">
                            <input name="email" type="email" class="form-control" id="floatingInput"
                                placeholder="name@example.com">
                            <label for="floatingInput">Email address</label>
                        </div>
                        <div class="form-floating">
                            <input name="password" type="password" class="form-control" id="floatingPassword"
                                placeholder="Password">
                            <label for="floatingPassword">Password</label>
                        </div>

                       
                        <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                        <p class="mt-5 mb-3 text-muted">&copy; 2022–2023</p>
                    </form>
                </div>
            </div>
            <script>
                document.getElementById("#login-btn").remove()
            </script>