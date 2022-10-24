<template>
	<view >
		<view class="select">
			<view class="select-text" @click="goindex()">
				  <text>进入多选</text>
			</view>
		
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			goindex ( ) {
				uni.navigateTo({
					url: '../index/index'
				});
			}
		}
	}
</script>

<style scoped>

	.select {
		position: absolute;
		bottom: 50%; 
		width: 50%; 
		left: 25%;
		background-color: #007AFF;
		height: 50px;
		border-radius: 6px
	}
	.select-text{
		text-align: center;
		line-height: 50px;
		color: #FFFFFF;
		font-size: 18px;
	}
</style>
