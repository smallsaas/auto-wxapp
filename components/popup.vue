<!-- 弹窗组件 -->
<template>
	<view>
		<scroll-view scroll-y="true" class="popup">
			<view style="height: 1em;width: 100%;border: none;"></view>
			<slot name="content"></slot>
		</scroll-view>
	</view>
</template>

<script>
	export default {
		name:"popup",
		data() {
			return {
				
			};
		},
		components:{
		}
	}
</script>

<style>
	@keyframes showWindow{
		from{height: 0;}
		to{height: 80%;}
	}
	.popup{
		position: fixed;
		bottom: 0;
		left: 0;
		animation-name: showWindow;
		animation-duration: .5s;
		/* right: 0; */
		height: 80%;
		width: 100%;
		background-color: white;
		border-top-left-radius: 10px;
		border-top-right-radius: 10px;
		z-index: 101;
	}
</style>
