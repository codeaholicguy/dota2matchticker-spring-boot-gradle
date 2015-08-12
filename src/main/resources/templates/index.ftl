<!DOCTYPE HTML>
<html ng-app="Dota2Matchticker">
<head>
    <title>Dota2Matchticker</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <!--[if lte IE 8]>
    <script src="/css/ie/html5shiv.js"></script><![endif]-->
    <script src="/js/jquery.min.js"></script>
    <script src="/js/jquery.scrolly.min.js"></script>
    <script src="/js/jquery.scrollzer.min.js"></script>
    <script src="/js/skel.min.js"></script>
    <script src="/js/skel-layers.min.js"></script>
    <script src="/js/init.js"></script>
    <noscript>
        <link rel="stylesheet" href="/css/skel.css"/>
        <link rel="stylesheet" href="/css/style.css"/>
        <link rel="stylesheet" href="/css/style-wide.css"/>
    </noscript>
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="/css/ie/v9.css"/><![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/css/ie/v8.css"/><![endif]-->
    <link rel="shortcut icon" href="/images/dota2_logo.png">
</head>
<body>

<!-- Header -->
<div id="header" class="skel-layers-fixed">

    <div class="top">

        <!-- Logo -->
        <div id="logo">
            <span class="image avatar48"><img src="/images/dota2_logo.png" alt=""/></span>

            <h1 id="title">Dota2Matchticker</h1>

            <p>v0.0.1</p>
        </div>

        <!-- Nav -->
        <nav id="nav">
            <ul>
                <li><a href="#live-matches-container" id="live-matches" class="skel-layers-ignoreHref"><span
                        class="dota2-logo">Live Matches</span></a></li>
                <li><a href="#upcomming-matches-container" id="upcomming-matches" class="skel-layers-ignoreHref"><span
                        class="dota2-logo">Upcomming Matches</span></a>
                </li>
                <li><a href="#recent-matches-container" id="recent-matches" class="skel-layers-ignoreHref"><span
                        class="dota2-logo">Recent Matches</span></a>
                </li>
            </ul>
        </nav>

    </div>

    <div class="bottom">

        <!-- Social Icons -->
        <ul class="icons">
            <li><a href="https://www.facebook.com/codeaholicguy" class="icon fa-facebook"><span
                    class="label">Facebook</span></a></li>
            <li><a href="https://www.twitter.com/codeaholicguy" class="icon fa-twitter"><span
                    class="label">Twitter</span></a></li>
            <li><a href="http://www.twitch.tv/codeaholicguy" class="icon fa-twitch"><span
                    class="label">Twitch</span></a></li>
            <li><a href="https://www.youtube.com/watch?v=becG3lLJ80w" class="icon fa-youtube"><span
                    class="label">Youtube</span></a></li>
            <li><a href="https://github.com/codeaholicguy" class="icon fa-github"><span class="label">Github</span></a></li>
        </ul>

    </div>

</div>

<!-- Main -->
<div id="main" ng-controller="MatchesController">
    <section id="live-matches-container" class="two">
        <header>
            <h2>Live Matches</h2>
        </header>
        <div class="container">
            <live-match></live-match>
        </div>
    </section>
    <section id="upcomming-matches-container" class="two">
        <header>
            <h2>Upcomming Matches</h2>
        </header>
        <div class="container">
            <upcomming-match></upcomming-match>
        </div>
    </section>
    <section id="recent-matches-container" class="two">
        <header>
            <h2>Recent Matches</h2>
        </header>
        <div class="container">
            <recent-match></recent-match>
        </div>
    </section>
</div>

<!-- Footer -->
<div id="footer">
    <!-- Copyright -->
    <ul class="copyright">
        <li>&copy; All rights reserved.</li><li>Design: <a href="http://codeaholicguy.github.io">codeaholicguy</a></li>
    </ul>
</div>

<script src="/js/angular.js"></script>
<script src="/js/angular-resource.js"></script>

<script src="/js/app.js"></script>

<script>
    (function (e, t, n, r, i, s, o) {
        e["GoogleAnalyticsObject"] = i;
        e[i] = e[i] || function () {
                    (e[i].q = e[i].q || []).push(arguments)
                }, e[i].l = 1 * new Date;
        s = t.createElement(n), o = t.getElementsByTagName(n)[0];
        s.async = 1;
        s.src = r;
        o.parentNode.insertBefore(s, o)
    })(window, document, "script", "//www.google-analytics.com/analytics.js", "ga");
    ga("create", "UA-54766983-1", "auto");
    ga("send", "pageview")
</script>
</body>
</html>
