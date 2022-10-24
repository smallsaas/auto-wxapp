<template>
	<view class="auto_form_select" v-if="show">
		<input class="auto_form_select_title"
			:placeholder="item.placeholder||`请选择${item.title}`||'请选择...'"
			v-model="value"
			readonly="true"
			@click="handleSelect()"
		/>
		<view class="auto_form_select_Box" v-show="click||item.readonly||item.disabled">
			<view @click="handleValue(itemValue)" class="auto_form_select_item" :key="i" v-for="(itemValue,i) in item.slot">
				{{itemValue.title}}
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name:"auto-form-select",
		props:{
			item:{
				type:Object,
				default(){
					return {}
				}
			},
			outValue:{
				type:Object,
				default(){
					return ""
				}
			}
		},
		data(){
			return {
				click:false,
				value:"",
				show:""
			}
		},
		created() {
			// this.value = this.item.placeholder||`请选择${this.item.title}`||'请选择...'
		},
		methods:{
			handleSelect(){
				this.click = !this.click
			},
			handleValue(item){
				this.value = item.title
				let value = {
					value:item.value,
					field:this.item.field
				}
				this.$emit("getValue",value)
				this.handleSelect()
			}
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
	}
</script>

<style>
	.auto_form_select_title{
		outline: none;
		width: 100%;
		font-size: 18px;
		height: 40px;
		line-height: 40px;
		border: none;
		/* margin: 5px 0; */
		cursor: pointer;
	}
	.auto_form_select_title:hover{
		background-color: #ccc8;
		transition: all .2s ease;
	}
	.auto_form_select_Box{
		border: 1px solid #999;
		position: page;
		width: 50%;
		text-align: left;
		list-style: none;
		background: #fff;
	}
	.auto_form_select_item{
		border-bottom: 1px solid #ccc;
		display: block;
		padding: 5px 10px;
		text-align: left;
		cursor: pointer;
	}
	.auto_form_select_item:hover{
		background-color: #ccc8;
		transition: all .2s ease;
	}
</style>
