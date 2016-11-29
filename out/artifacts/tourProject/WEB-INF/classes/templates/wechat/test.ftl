<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<#include "common/head.ftl">
    <title>及应</title>
</head>

<body>
    <div class="page">
        <header class="bar bar-nav">
            <h1 class='title'>Secondary tabs</h1>
        </header>
        <div class="content">
            <div class="content-block">
                <div class="buttons-row">
                    <a href="#tab1" class="tab-link active button">Tab 1</a>
                    <a href="#tab2" class="tab-link button">Tab 2</a>
                </div>
            </div>
            <div class="tabs">
                <div id="tab1" class="tab active">
                    <div class="content-block">
                        <p>This is tab 1 content</p>
                    </div>
                </div>
                <div id="tab2" class="tab">
                    <div class="content-block">
                        <p>This is tab 2 content</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
<#include "common/js.ftl">
</html>