/**
 * 
 */
function startchating() {
    var user_name = document.getElementById('username');
    var pass_word = document.getElementById('pword');
    if (user_name.value === '' || pass_word.value === '') {
        alert('Please login to continue.');
        return false;
    }

    var xmlhttp;
    if (window.XMLHttpRequest) { 
        xmlhttp = new XMLHttpRequest();
    } else { 
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("POST", "/OneChat/CheckUser?uname=" + user_name.value + "&pw=" + pass_word.value, true);

    document.getElementById("loading-icon").innerHTML = '<img src="loader.gif" border="0" alt="Loading, please wait..." />';
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            if (xmlhttp.responseText.indexOf('Incorrect') !== -1) {
                document.getElementById("loading-icon").innerHTML = "<h4 style='color:red'>" + xmlhttp.responseText + "<h4>";
            } else {
                document.getElementById("result-data").innerHTML = '<h1>' + xmlhttp.responseText + '</h1>';
            }


        }


    };
    xmlhttp.send(null);

}
//To retrieve chat messages
function RetrieveChatJS()
{
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }


    xmlhttp.open("POST", "/OneChat/RetrieveChatData", true);

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {

            document.getElementById("chatcon").innerHTML = xmlhttp.responseText;
            olist = document.getElementById('list'); //everything in id list
            olist.scrollTop = olist.scrollHeight;


        }


    };
    xmlhttp.send(null);
}

function sendMsg ()
{
 var username = document.getElementById('"strUsername"').value;
    var msg = document.getElementById('strMsgChat').value;
    chatlist = document.getElementById('list');
    chatp = document.createElement('p');
    chatp.innerHTML = username + "- <g>" + msg + "</g>";
    chcontent = document.getElementById('chatcon');
    chcontent.appendChild(chatp);             
    chatlist.scrollTop = chatlist.scrollHeight; 
    document.getElementById('strMsgChat').value = '';
    var xmlhttp;
    if (window.XMLHttpRequest)
    {
        xmlhttp = new XMLHttpRequest();
    }
    else
    {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("POST", "/OneChat/DisplayChat?uname=" + username + "&msg=" + msg, true);

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200)
        {
            document.getElementById("result").innerHTML = 'sent';
            document.getElementById("result").innerHTML = '';
        }
    };
    xmlhttp.send(null);
    }