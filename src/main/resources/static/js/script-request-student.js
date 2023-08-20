class ScriptRequestStudent {
    static startJquery = () =>  { /* I need function it's not method */
        let age , fullname , weight , height , nisitYear
        function setEvent() {
            /* # called id of tag html */
            $('#form-student').submit(function (event) { /* when happen user clicked submit */
                event.preventDefault() /* stop reload when clicked button */
                /*
                    .val() method use to get value of tag html
                    should use when happen the action
                */
                age = $('#age').val()
                fullname = $('#fullname').val()
                weight = $('#weight').val()
                height = $('#height').val()
                nisitYear = $('#nisitYear').val()
                // console.log(age,fullname,weight,height,nisitYear)
                // console.log("found event")
                const validate = validateForm(age,fullname,weight,height)
                if (validate) {
                    $('#submit').hide(1100); /* hide the button */
                    setAjax(age,fullname,weight,height,nisitYear) /* called setAjax() for send request */
                }
            })
        }
        function validateForm(age , fullname , weight , height) { /* test validate and alert some messages to user */
            const msgInvalid = "shouldn't be empty" , msgValid = "valid"
            let bool = false
            /* when user didn't put anything  */
            if ((age === "") && (fullname.trim().length === 0) && (weight === "") && (height === "")) {
                $('#alert-age').html(msgInvalid).css("color", "red")
                $('#alert-fullname').html(msgInvalid).css("color", "red")
                $('#alert-weight').html(msgInvalid).css("color", "red")
                $('#alert-height').html(msgInvalid).css("color", "red")
            }
            /* these case below , I just check when user put on only 1 input */
            else if ((age !== "") && (fullname.trim().length === 0) && (weight === "") && (height === "")) {
                $('#alert-age').html(msgValid).css("color", "green")
                $('#alert-fullname').html(msgInvalid).css("color", "red")
                $('#alert-weight').html(msgInvalid).css("color", "red")
                $('#alert-height').html(msgInvalid).css("color", "red")
            }
            else if ((age === "") && (fullname.trim().length !== 0) && (weight === "") && (height === "")) {
                $('#alert-age').html(msgInvalid).css("color", "red")
                $('#alert-fullname').html(msgValid).css("color", "green")
                $('#alert-weight').html(msgInvalid).css("color", "red")
                $('#alert-height').html(msgInvalid).css("color", "red")
            }
            else  if ((age === "") && (fullname.trim().length === 0) && (weight !== "") && (height === "")) {
                $('#alert-age').html(msgInvalid).css("color", "red")
                $('#alert-fullname').html(msgInvalid).css("color", "red")
                $('#alert-weight').html(msgValid).css("color", "green")
                $('#alert-height').html(msgInvalid).css("color", "red")
            }
            else if ((age === "") && (fullname.trim().length === 0) && (weight === "") && (height !== "")) {
                $('#alert-age').html(msgInvalid).css("color", "red")
                $('#alert-fullname').html(msgInvalid).css("color", "red")
                $('#alert-weight').html(msgInvalid).css("color", "red")
                $('#alert-height').html(msgValid).css("color", "green")
            }
            /* these case on top lines , I just check when user put on only 1 input */
            else if ((age !== "") && (fullname.trim().length !== 0) && (weight !== "") && (height !== "")) {
                $('#alert-age').html(msgInvalid).css("color", "green")
                $('#alert-fullname').html(msgInvalid).css("color", "green")
                $('#alert-weight').html(msgInvalid).css("color", "green")
                $('#alert-height').html(msgValid).css("color", "green")
                bool = true
            }
            return bool
        }
        function setAjax(age,fullname,weight,height,nisitYear) { /* using ajax to send request to my control in java class */
            $.ajax({
                url : '/api/add-student',
                type : 'post' ,
                json : 'json' ,
                data : { age,fullname,weight,height,nisitYear } , /* parameter will map to args of java method */
                success : function () {
                    /* when your req was success in {} will do something */
                    $('#goto-second').html("<a class=\"btn btn-primary\" href='/api/get-student' >all students</a>").show(2000)
                }
            })
        }

        $(document).ready(function () { /* start Jquery */
            setEvent()
        })
    }

}

ScriptRequestStudent.startJquery()
