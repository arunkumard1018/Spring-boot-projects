<%@ include file="comman/head.jspf" %>
<title>Login</title>
</head>

<body class="bg-gray-200">
    <%@ include file="comman/nav.jspf" %>
    <div class="flex items-center justify-around mx-60 my-12 space-x-5">
        <div class="box h-[34rem] border w-1/3">

        </div>
        <div class="box h-[34rem] border w-2/3">
            <div class="form-container bg-white m-5 flex items-center justify-center flex-col space-y-4 p-10 rounded-md">
                <h1 class="w-[60%] text-center text-[1.8rem]">Sign in Or Create Account</h1>
                <form action="/login" method="post" class="w-[60%] flex flex-col" >
                    
                    <label class="text-sm pb-1" for="">User Name</label>
                    <input type="text" name="userName" class="p-2 border  hover:border-blue-600 focus:outline-none " />
                    
                    <label class="text-sm pb-1"  for="">Password</label>
                    <input type="password" name="password" class="p-2 border  hover:border-blue-600 focus:outline-none">
                    
                    <button type="submit" class="p-2 mt-5 bg-blue-600">Login</button>
                </form>
                
                <button type="submit" class="bg-blue-600 w-[60%] flex items-center justify-center space-x-4 space-y-2">
                    <img src="images/google.png" alt="">
                    <Span class="pb-2">Google</Span>
                </button>
                <button type="submit" class="bg-blue-600 w-[60%] flex items-center justify-center space-x-4 space-y-2">
                    <img src="images/apple.png" alt="">
                    <Span class="pb-2">Apple</Span>
                </button>
                <button type="submit" class="bg-blue-600 w-[60%] flex items-center justify-center space-x-4 space-y-2">
                    <img src="images/facebook.png" alt="">
                    <Span class="pb-2">Facebook</Span>
                </button>
                
            </div>
        </div>
    </div>
    
    <%@ include file="comman/footer.jspf" %>
</body>

</html>