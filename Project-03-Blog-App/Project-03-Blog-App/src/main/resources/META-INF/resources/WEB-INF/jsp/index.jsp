<%@ include file="comman/head.jspf" %>
<title>home-page</title>
</head>

<body>
    <%@ include file="comman/nav.jspf" %>
    <main>
        <div class="mx-60 ">
            <div class="catagory mt-10">
                <select class="border py-1 px-3 hover:border-blue-300 rounded-md" name="Catgory" id="">
                    <option value="politics">All</option>
                    <option value="science">science</option>
                    <option value="Business">Business</option>
                </select>
            </div>
            <div class="border border-x-0 border-t-4 border-b-0 border-t-black mt-8">
                <span class="font-bold text-white bg-black py-1 px-4">Post Catogory</span>
            </div>
            <div class="flex w-[100%]  flex-wrap justify-evenly pt-4 space-x-9">
                <div class="post-container w-1/5">
                    <a href="#">
                        <div class="h-[38rem] space-y-1 flex flex-col justify-around">
                            <img class="w-[100%] h-[16rem]" src="images/image-01.jpg" alt="">
                            <p class="font-bold text-black h-[4.9rem] overflow-y-hidden text-left hover:underline">Lorem
                                ipsum dolor sit
                                amet consectetur adipisicing elit. Atque, laboriosam. Lorem ipsum dolor sit amet,</p>
                            <p class="text-gray-900 h-[12rem] overflow-y-hidden text-justify">Lorem ipsum dolor sit amet
                                consectetur adipisicing elit. Deserunt ea ad tempore fugit maxime quaerat? Non neque
                                facere
                                error sapiente! Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum,
                                voluptatum
                                maxime numquam consequatur, quas id fuga itaque, odio porro a rerum soluta perspiciatis
                                explicabo ratione eum dolores corporis. Deleniti, earum.
                            </p>
                            <a href="/author"><span class="items-end h-[2rem] font-mono text-sm font-bold ">Author
                                    name</span></a>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </main>
    <%@ include file="comman/footer.jspf" %>
</body>
</html>