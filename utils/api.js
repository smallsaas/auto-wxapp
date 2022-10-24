import {globalConfig} from '@/config.js'
/**
 * request请求
 * 属性：
 * endpoint：节点地址
 * url：地址
 * data：传入数据
 * method：请求方法
 * header：头部
 * dataType：数据类型
 * 使用方法：
 * 在main.js中复制粘贴以下代码
 * import request from '@/utils/api.js'
 * Vue.prototype.$request = request
 * 然后在项目中直接使用this.$request即可  
 */
const request = (url = '', data = {}, method = 'GET', header = {
},dataType = 'json',endpoint=globalConfig.endpoint) => {
    return new Promise((resolve, reject) => {
        uni.request({
            method: method,
            url: endpoint + url,
            data: data,
            header: header,
            dataType: dataType,         
        }).then((response) => {
            setTimeout(function() {
                uni.hideLoading();
            }, 200);
            let [error, res] = response;		
            // resolve(res.data);
			handleSuccess(res.data, resolve)
        }).catch(error => {
            let [err, res] = error;
            // reject(err)
			handleError(res.data, reject)
        })
    });
}
const handleSuccess = (res,resolve) => {
	if(res.code === 401){
		
	}else if(res.code === 502 || res.code === 404){
		setTimeout(() => {
			uni.navigateTo({
				url: '/pages/tipsPage/index'
			})
		}, 200)
	}else {
		resolve(res)
	}
}

const handleError = (res, reject) => {
	if(res.code === 401){
		
	}else if(res.code === 502 || res.code === 404){
		setTimeout(() => {
			uni.navigateTo({
				url: '/pages/tipsPage/index'
			})
		}, 200)
	}else{
		reject(res)
	}
}
export default request