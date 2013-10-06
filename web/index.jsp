<%-- 
    Document   : index
    Created on : 28.11.2009, 14:45:25
    Author     : Dave
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/edison.tld" prefix="edison" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="STYLESHEET" type="text/css" href="css/style.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Můj zelený systém - projekt JAT</title>
        <script type="application/javascript" src="script/jquery-1.3.2.min.js" ></script>
        <script type="text/javascript">
        $(document).ready(function() {
            $(".wrapper").hide();
            $(".element").hover(
                function() {
                        $(this).addClass("cfocus");
                },
                function() {
                        $(this).removeClass("cfocus");
                }
            );
            $(".show").click(function() {
                child = $(this).children("a");
                if($(this).children("a").hasClass("shown")) {
                    $(this).children("a").removeClass("shown");
                    var value = $(this).children("a").attr("class");
                    $("#" + value).hide();
                    $(this).children("a").text("Zobrazit");
                } else {
                    var value = $(this).children("a").attr("class");
                    $("#" + value).animate({opacity: "show"}, "slow");
                    $(this).children("a").text("Skrýt");
                    $(this).children("a").addClass("shown");
                }
            });
        });
        </script>
    </head>
    <body>
        <div class="head">
            <div class="title"><h1>Můj zelený systém - Projekt JAT</h1></div>
        </div>
        <div class="body">
            <div class="left">
                <div class="element">
                    <a href="Controler?action=student">Seznam studentů</a>
                </div><div class="element">
                    <a href="Controler?action=predmet">Seznam předmětů</a>
                </div><div class="element">
                    <a href="Controler?action=garant">Seznam učitelů</a>
                </div>
            </div>
            <div class="right">
                <c:if test='${param.action=="student" }'>
                    <edison:StudentList garant="0">
                        <div class="block">
                        <b>Id</b> : <edison:Student parameter="id" />&nbsp;&nbsp;&nbsp;&nbsp;
                        <b>Jméno</b> : <edison:Student parameter="name" />
                        <span style="float:right" class="show">
                            <a name="" style="color:black" class="<edison:Student parameter='id'/>" >Zobrazit</a>
                        </span>
                        <div id="<edison:Student parameter='id'/>" class="wrapper">
                        <edison:PrubehList>
                            <div class="block2">
                            <div class="subblock">Id předmětu<br /><edison:Prubeh parameter="id"/></div>
                            <div class="subblock">Název<br /><edison:Prubeh parameter="name" /></div>
                            <div class="subblock">Zapsán na předmět<br /><edison:Prubeh parameter="register" /></div>
                            <div class="subblock">Body za předmět<br /><edison:Prubeh parameter="points" /></div>
                            <div class="subblock">Chodí na cvičení<br /><edison:Prubeh parameter="date" /></div>
                            </div>
                        </edison:PrubehList>
                        </div>
                        </div>
                    </edison:StudentList>
                </c:if>
                <c:if test='${param.action=="predmet" }'>
                    <edison:PredmetList>
                        <div class="block">
                        <b>Id</b> : <edison:Predmet parameter="id" />&nbsp;&nbsp;&nbsp;&nbsp;
                        <b>Název</b> : <edison:Predmet parameter="name" />&nbsp;&nbsp;&nbsp;&nbsp;
                        <b>Kredity za předmět</b> : <edison:Predmet parameter="credits" />&nbsp;&nbsp;&nbsp;&nbsp;
                        <b>Garant předmětu</b> : <edison:Predmet parameter="garant" />
                        <span style="float:right" class="show">
                            <a name="" style="color:black" class="<edison:Predmet parameter='id'/>" >Zobrazit</a>
                        </span>
                        <div id="<edison:Predmet parameter='id'/>" class="wrapper">
                        <edison:NavstevujeList>
                            <div class="block2">
                            <div class="subblock">Id studenta<br /><edison:Navstevuje parameter="id"/></div>
                            <div class="subblock">Jméno studenta<br /><edison:Navstevuje parameter="name" /></div>
                            <div class="subblock">Zapsán na předmět<br /><edison:Navstevuje parameter="register" /></div>
                            <div class="subblock">Body za předmět<br /><edison:Navstevuje parameter="points" /></div>
                            <div class="subblock">Chodí na cvičení<br /><edison:Navstevuje parameter="date" /></div>
                            </div>
                        </edison:NavstevujeList>
                        </div>
                        </div>
                    </edison:PredmetList>
                </c:if>
                <c:if test='${param.action=="garant" }'>
                    <edison:StudentList garant="1">
                        <div class="block">
                        <b>Id</b> : <edison:Student parameter="id" />&nbsp;&nbsp;&nbsp;&nbsp;
                        <b>Jméno</b> : <edison:Student parameter="name" />&nbsp;&nbsp;&nbsp;&nbsp;
                        <span style="float:right" class="show">
                            <a name="" style="color:black" class="<edison:Student parameter='id'/>" >Zobrazit</a>
                        </span>
                        <div id="<edison:Student parameter='id'/>" class="wrapper">
                        <edison:VyucujeList>
                            <div class="block2">
                            <div class="subblock">Id předmětu<br /><edison:Predmet parameter="id" /></div>
                            <div class="subblock">Název předmětu<br /><edison:Predmet parameter="name" /></div>
                            </div>
                        </edison:VyucujeList>
                        </div>
                        </div>
                    </edison:StudentList>
                </c:if>
            </div>
        </div>
        <div class="foot">
                webmaster &amp; design David Krutký, &#64; 2009
        </div>
    </body>
</html>
