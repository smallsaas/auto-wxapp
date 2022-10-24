<!-- 
* 表单标题
* item属性
* title:标题名
* 所有插槽slot
* body 
 -->
<template>
	<view class="field">
		<view class="field-title" v-if="item.title">
			<span style="color: red;" v-if="item.required">*</span>{{item.title}} :</view>
		<view class="field-body">
			<slot name="body"></slot>
		</view>
	</view>
</template>

<script>
	export default {
		name:"auto-field",
		props:{
			item:{
				type:Object,
				default(){
					return {}
				}
			}
		},
		created() {
			// console.log(this.item)
		}
	}
</script>

<style>
	.field{
		/* background-color: #000000; */
		/* text-align: center; */
		position: relative;
		left: 50%;
		transform: translate(-50%);
		display: flex;
		flex-direction: column;
		padding: 10px;
	}
	.field-title{
		font-weight: bolder;
		/* width:7em; */
		text-align: left;
		margin-bottom: 5px;
		font-size: 15px;
/* 		position: absolute;
		top: -50%;
		transform: translate(0,-50%); */
		/* height: 40px; */
		margin-right: 5px;
	}
	.field-body{
		flex: 1;
		position: relative;
	}
</style>
