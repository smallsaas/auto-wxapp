<!-- 遮罩层组件,层数为100 -->
<template>
	<view class="mock" @click="onClick()">
		
	</view>
</template>

<script>
	export default {
		name:"mock",
		data() {
			return {
				
			};
		},
		props:{
		},
		methods:{
			onClick(){
				this.$emit('click')
			}
		}
	}
</script>

<style>
	.mock{
		position: fixed;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
		background-color: #333333;
		z-index: 100;
		opacity: .8;
	}
</style>
