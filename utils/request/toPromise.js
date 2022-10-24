
// 封装Promise
export const toPromise = (fn) => {
	uni.showLoading({
		title:'',
		mask: true
	})
  return (obj = {}) => {
    return new Promise((resolve, reject) => {
		setTimeout(() => {
			uni.hideLoading()
			obj.success = (res) => {
			  res = res.data ? res.data : res
			  // resolve(res)
			  handleSuccess(res, resolve)
			}
			obj.fail = (res) => {
				
				// reject(res)
				handleError(res, reject)
			  // // console.log('reject==', res)
			}
			fn(obj)
		}, 600)
     
    })
  }
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

module.export = {
  toPromise
}
