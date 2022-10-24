<!-- 
* 输入框组件
* item属性：
* value：值
* placeholder：注释
* readonly：是否只读
* disabled：是否不可用
* 事件：
* @getValue：获取输入框值
 -->
<template>
	<view class="auto_form_input" v-if="!show">
		<input class="auto_form_inputBox" 
		:placeholder="item.placeholder||`请输入${item.title}`||'请输入...'" 
		:readonly="item.readonly"
		:disabled="item.disabled"
		type="text"
		placeholder-style="color:#ccc;"
		v-model="value"
		@input="getValue()"
		/>
	</view>
</template>

<script>
	export default {
		name:"auto-input",
		props:{
			item:{
				type:Object,
				default(){
					return {}
				}
			},
			outValue:{
				type:String
			}
		},
		data(){
			return {
				value:"",
				show:false
			}
		},
		created() {
			this.init()
		},
		watch:{
			outValue:{
				handler(val,oldVal){
					// console.log(val,oldVal)
					this.value = val
					this.show = true
					this.show = false
				}
			}
		},
		methods:{
			// 初始化
			init(){
				this.value = this.outValue||this.item.value||""
				let value = {
					value:this.value,
					field:this.item.field
				}
				this.$emit("getValue",value)
			},
			getValue(){
				let value = {
					value:this.value,
					field:this.item.field
				}
				this.$emit("getValue",value)
			}
		}
	}
</script>

<style>
	.auto_form_input{
		width: 100%;
		/* border-bottom: 1px solid #ccc; */
		/* box-shadow: 0px 0px 5px #999999; */
		background-color: #F0EEF5;
	}
	.auto_form_inputBox{
		outline: none;
		/* width: 100%; */
		font-size: 16px;
		font-weight: bolder;
		border: none;
		height: 40px;
		text-align:left;
		margin-left:10px;
		line-height: 40px;
	}
</style>
