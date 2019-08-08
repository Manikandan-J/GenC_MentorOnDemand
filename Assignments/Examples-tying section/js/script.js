var bk = document.getElementById("background");
var cr = ["black ", "blue ", "brown ", "green ", "orange ", "red ", "grey "];
var i = 0;
setInterval(blk, 1000);

function blk() {
    bk.style.backgroundColor = cr[i];
    i++;
    if (i > cr.length - 1) {
        i = 0;
    }
}

var sum = 0;
var bt = document.getElementById("bt");
bt.addEventListener('click', function() {

    var ip = parseInt(prompt("Enter a number : "));
    if (ip === "") {
        alert("No input number has been provided ");
        return false;
    } else if (isNaN(ip)) {
        alert("Entered value is not a number ");
        return false;
    } else {
        sum += ip;
    }
    // console.log(sum);
    alert("Sum is : " + sum);
});

var but = document.getElementById("but");
but.addEventListener('click', function() {
    var ips = prompt("Enter a String : ");
    var str = "";
    if (ips === "") {
        alert("No input string has been provided ");
        return false;
    } else {
        for (var ik = 0; ik <= ips.length; ik++) {
            ips = ips.slice(0, ips.length - 1);
            // console.log(ips);
            str += "\n" + ips;
        }
    }
    alert(str);
});

var butto = document.getElementById("butto");
butto.addEventListener('click', function() {
    var pat = /^[0-9]{0,}[\s][0-9]{0,}$/g;
    var inp = prompt("Enter two numbers seperated by a space to add: ");
    if (inp === "") {
        alert("No input number has been provided");
        return false;
    } else if (!(pat.test(inp))) {
        alert("Please match the pattern");
        return false;
    } else {
        var arr, b, c;

        arr = inp.split(" ");
        b = parseInt(arr[0]) + parseInt(arr[1]);
        // console.log(b);
        alert("The sum is : " + b);
    }
});

var myInput = document.getElementById("myInput");
myInput.addEventListener('focus', function() {
    document.getElementById("myInput").style.background = "yellow";
});
myInput.addEventListener('blur', function() {
    document.getElementById("myInput").style.background = "white";
});