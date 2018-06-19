<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Safe</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <style type="text/css">
        body {
            font-family: Helvetica, Arial, sans-serif;
            font-size: 0.9em;
            text-rendering: optimizeLegibility;
        }
        select {
            -moz-appearance: none;
            -webkit-appearance: none;
            appearance: none;
        }
        select::-ms-expand {
            display: none;
        }
        #main{
            width:600px;
            height:400px;
            display: block;
        }
        #line{
            position:relative;
            margin-top:400px;
            z-index=0;
        }
        span{
            padding-right:7.8%;
            padding-left:4.7%;
        }
        #result5{
            width:600px;
            position:absolute;
            top:80px;
            z-index=1;
        }
        #result4{
            width:600px;
            position:absolute;
            top:160px;
            z-index=1;
        }
        #result3{
            width:600px;
            position:absolute;
            top:240px;
        }
        #result2{
            width:600px;
            position:absolute;
            top:320px;
        }
        #result1{
            width:600px;
            position:absolute;
            top:400px;
            z-index=1;
        }
    </style>
    <script>
        function getRandom() {
            var arr=[];
            var check=false;
            for( i = 0; i < 4; ++i) {
                var temp=parseInt(Math.random()*10);
                for( j = 0; j < 4; ++j) {
                    if(temp==arr[j]){
                        --i;
                        check=false;
                        break;
                    }else{
                        check=true;
                    }
                }
                if(check){
                    arr[i]=temp;
                }
            }
            return arr;
        }
        var arr=getRandom();

        function dep(element,val) {
            var item=parseInt($(element+" :selected").val())+parseInt(val);

            $(element+" [value='"+item+"']").prop('selected', true);
        }

        var hod=1;

        function submit(s1,s2,s3,s4){
            if($(s1+" :selected").val()==arr[0] && $(s2+" :selected").val()==arr[1] && $(s3+" :selected").val()==arr[2] && $(s4+" :selected").val()==arr[3])
            {
                $('#log').empty();
                $('#log').append('Совпадений = '+temp+'      На своих местах = '+check+'    Ответ = '+arr[0]+arr[1]+arr[2]+arr[3]+'    Сейф  вскрыт');
                $('#line').remove();
                return;
            }
            $('#log').empty();
            if($(s1+" :selected").val()==$(s2+" :selected").val() || $(s1+" :selected").val()==$(s3+" :selected").val() || $(s1+" :selected").val()==$(s4+" :selected").val()){
                $('#log').append('Нельзя повторять числа');
                return;
            }
            if($(s2+" :selected").val()==$(s3+" :selected").val() || $(s2+" :selected").val()==$(s4+" :selected").val()){
                $('#log').append('Нельзя повторять числа');
                return;
            }
            if($(s3+" :selected").val()==$(s4+" :selected").val()){
                $('#log').append('Нельзя повторять числа');
                return;
            }
            var check=0;
            var temp=0;
            for(i=0;i<4;i++){
                if($(s1+" :selected").val()==arr[i] || $(s2+" :selected").val()==arr[i] || $(s3+" :selected").val()==arr[i] || $(s4+" :selected").val()==arr[i]){
                    temp++;
                    if(($(s1+" :selected").val()==arr[i] && i==0) || ($(s2+" :selected").val()==arr[i] && i==1) || ($(s3+" :selected").val()==arr[i] && i==2) || ($(s4+" :selected").val()==arr[i] && i==3)){
                        check++;
                    }
                }
            }

            var position=parseInt($('#line').css('margin-top'))-80;
            $('#result'+hod).append('<span>'+$(s1+" :selected").val()+'</span><span>'+$(s2+" :selected").val()+'</span><span>'+$(s3+" :selected").val()+'</span><span>'+$(s4+" :selected").val()+'</span>|<span>'+temp+'</span><span>'+check+'</span>');
            if(hod==5){
                $('#log').empty();
                $('#log').append('Совпадений = '+temp+'      На своих местах = '+check+'    Ответ = '+arr[0]+arr[1]+arr[2]+arr[3])+'    Сейф закрыт';
                $('#line').remove();
                return;
            }
            hod+=1;
            $('#line').animate({
                marginTop: position
            }, 1000);
            $('#log').append('Совпадений = '+temp+'      На своих местах = '+check);
        }
    </script>
</head>
<body>
<div>
    Лог = <span id=log></span>
</div>
<div id="main">
    <div id="result1"></div>
    <div id="result2"></div>
    <div id="result3"></div>
    <div id="result4"></div>
    <div id="result5"></div>
    <div id="line">

        <div class="select1" name="s1" style="width:13%;display:inline-block;">
            <input type="button" value="↓" onclick="dep('.select1',-1)"/>
            <select>
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
            </select>
            <input type="button" value="↑" onclick="dep('.select1',1)"/>
        </div>
        <div class="select2" name="s2" style="width:13%;display:inline-block;">
            <input type="button" value="↓" onclick="dep('.select2',-1)"/>
            <select>
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
            </select>
            <input type="button" value="↑" onclick="dep('.select2',1)"/>
        </div>
        <div class="select3" name="s3" style="width:13%;display:inline-block;">
            <input type="button" value="↓" onclick="dep('.select3',-1)"/>
            <select>
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
            </select>
            <input type="button" value="↑" onclick="dep('.select3',1)"/>
        </div>
        <div class="select4" name="s4" style="width:13%;display:inline-block;">
            <input type="button" value="↓" onclick="dep('.select4',-1)"/>
            <select>
                <option value="0">0</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
            </select>
            <input type="button" value="↑" onclick="dep('.select4',1)"/>
        </div>
        <input type="button" value="Отправить" onclick="submit('.select1','.select2','.select3','.select4')"/>
    </div>
</div>
</body>
</html>