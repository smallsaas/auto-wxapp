<template>

	<view class="dynamic-project-list">
		<view class="dynamic-project-item" v-for="(item,index) in list" :key="index">
			<view class="dynamic-project-item-body">
				<view style="font-size:12px;font-weight:bolder" @click="get(item.id,index)">项目名称:{{item.name}}</view>
				<view style="font-size:12px;font-weight:bolder">项目标题:{{item.logo}}</view>
				<view style="position: absolute;bottom: -28px;right: 5px;" @click="deleteItem(item.id)">
					<image src="../../static/delete.png" style="width: 20px;" mode="widthFix"></image>
				</view>
				<view  style="position: absolute;top: -34px;right: 2px;zoom:0.8">
					<!-- <radio value="1"></radio>
						 -->
					<checkbox id="checkbox" @change @click="getcheckbox(item.id)"></checkbox>
						
				</view>
			</view>

		</view>
		<view class="dynamic-project-add" @click="changeProp()">
			<image src="../../static/add.png"
				style="width: 30px;position: absolute;top: 50%;left: 50%;transform: translate(-50%,-50%);"
				mode="widthFix"></image>
			<!-- <p1 style="position: absolute; left: 45%; top: 40%;">购买</p1> -->
		</view>
		<view v-show="show">
			<mock @click="changeProp()"></mock>
			<popup>
				<div slot="content">
					<auto-form :package="formPackage" :value="apiData" v-if="formPackage"></auto-form>
				</div>
			</popup>
		</view>
		<view class="dynamic-button" v-for="">
			<view class="dynamic-button-text">
				<text id="query" @click="queryId()">查询</text>
			</view>
		</view>
		
	</view>

</template>

<script>
	import json from '@/json/form.json'
	import mock from '@/components/mock.vue'
	import popup from '@/components/popup.vue'
	import autoForm from '@/components/auto_form/index.vue'
	export default {
		data() {
			return {
				list: [],
				data: {

				},
				show: false,
				formPackage: null,
				apiData: {},
				checkboxData: [],
			}
		},
		components: {
			popup,
			mock,
			autoForm
		},
		created() {
			this.formPackage = json
			this.search()
		},
		methods: {
			changeProp() {
				this.init()
				this.show = !this.show
			},
			// 增加
			init() {
				// this.list = []
				this.apiData = {}
			},
			add() {
				this.init()
				let data = {
					ordId: this.ordId
				}
				let that = this
				this.$request("/api/crud/lc_low_auto_app/lowAutoApp/lowAutoApps", data, "post").then((res) => {
					// console.log(res)
				})

			},
			get(id, index) {
					// console.log(id)
				// this.init()
				// let that = this
				// this.$request(`/api/crud/lc_low_auto_app/lowAutoApp/lowAutoApps?id=${id}`).then((res) => {
				// 	that.changeProp()
				// 	console.log(res.data.records)
				// 	that.apiData = res.data.records[0]
				// 	that.apiData.id = id
				// })
				this.changeProp()
				this.apiData = this.list[index]
			},
			getcheckbox(id) {
				// console.log(id)
				// 先判断id是否存在于checkboxData中
				// 如果有，则删除
				// 如果没有，则添加
				if (this.checkboxData.indexOf(id) > -1) {
					let remoterId = this.checkboxData.indexOf(id)
					this.checkboxData.splice(remoterId,1)
				} else {
					this.checkboxData.push(id)
				}
				
				
				
		
				
				
				// console.log(this.checkboxData);
				
				// let that = this
				// this.$request(`/api/crud/lc_low_auto_app/lowAutoApp/lowAutoApps?id=${id}`).then((res) => {
				// 	// that.changeProp()
					
				// 	that.apiData = res.data.records[0]
				// 	that.apiData.id = id
				// 	console.log(that.apiData.id)
				// })
			},

			deleteItem(id) {
				this.$request(`/api/crud/lc_low_auto_app/lowAutoApp/lowAutoApps/${id}`, {}, "delete").then((res) => {
					uni.showLoading({
						title: "删除中"
					})
					uni.reLaunch({
						url: `/pages/index/index`,
						success() {
							uni.hideLoading()
							uni.showToast({
								title: "删除成功",
								duration: "2s"
							})
						}
					})
				})
			},
			// 查询列表
			search() {
				this.$request('/api/crud/lc_low_auto_app/lowAutoApp/lowAutoApps').then((res) => {
					this.list = res.data.records
					// console.log(this.list)
				})
			},
			//###根据appId查询page页面
			//GET {{local}}/api/crud/lc_low_auto_page/lowAutoPage/lowAutoPages/getPageByAppId/{id}
			queryId() {
				// let id = this.checkboxData
				this.$request(`/api/crud/lc_low_auto_page/lowAutoPage/lowAutoPages/getPageByAppId/${this.checkboxData}`).then((res) => {
					this.checkboxData = res.data.records
					console.log(this.checkboxData)
				})
				// this.clearCheckBoxState()
				//选择完把内容为新的至page页面	
				uni.navigateTo({
					url: '../pagecontents/pagecontents'
				});
					
			},
			
			// 清理checkbox状态
			clearCheckBoxState () {
				    document.getElementById("checkbox").checked = false
				// let checkbox = document.getElementsByClassName('checkbox')
				// for (var i = 0; i < checkbox.length; i++) {
				// 	// console.log(checkbox.length);//4
				// 	checkbox[i].checked = false
				// }
			}







		}
	}
</script>

<style>
	page {
		background-color: #F4F5F8;
	}

	.dynamic-project-list {
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		align-items: center;
	}

	.dynamic-project-add,
	.dynamic-project-item {
		width: 140px;
		margin: 20px auto;
		height: 100px;
		border-radius: 10px;
	}

	.dynamic-project-add {
		/* border: 2px dotted #333; */
		position: relative;
		background-color: white;
		box-shadow: 0px 0px 2px #d9d9d9;
	}

	.dynamic-project-item {
		position: relative;
		background-color: white;
		box-shadow: 0px 0px 2px #9c9c9c;
	}

	.dynamic-project-item-body {
		width: 100%;
		/* height: 20px; */
		text-align: center;
		display: flex;
		flex-direction: column;
		position: relative;
		top: 50%;
		transform: translate(0, -50%);
		color: #666666;
	}

	.dynamic-button {
		position: absolute;
		bottom: 0;
		width: 100%;
		background-color: #007AFF;
		height: 50px;
		border-radius: 6px
	}

	.dynamic-button-text {
		text-align: center;
		line-height: 50px;
		color: #FFFFFF;
		font-size: 18px;
	}
</style>
