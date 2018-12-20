function fun(){
    var arr = new Array(3);
    for (i = 0 ; i <arr.length ; i ++){
        arr[i] = i
    }
    var str = "数组的内容为：";
    for (i = 0 ; i <arr.length ; i ++){
        str += arr[i] + "、";
    }
    return str;
}