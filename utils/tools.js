// 判断值是否为undefined,null或""
export const isNull = (value) =>{
	let status;
	if(value===undefined||value===null||value===""){
		status = false;
	}else{
		status = true;
	}
	return status
}