<!-- 
* 自动表单（auto_form）
* package中拥有的属性
* 
 -->
<template>
  <view class="auto_form">
    <!-- <view class="auto_form_title">{{package.title}}</view> -->
    <view class="auto_form_body">
      <auto-field :item="item_" :key="i_" v-for="(item_, i_) in package.components">
        <view slot="body">
          <auto-input v-if="item_.type === 'input'" :item="item_" :outValue="getOutValue(item_.field)" @getValue="getValue"></auto-input>
          <auto-select v-if="item_.type === 'select'" :item="item_" :outValue="getOutValue(item_.field)" @getValue="getValue"></auto-select>
        </view>
      </auto-field>
    </view>
    <view class="auto_form_button_box">
      <button class="auto_form_button sumbit" :disabled="disabled === 0" @click="getJSON()">{{ package.sumbitConfig.title || '提交' }}</button>
    </view>
  </view>
</template>

<script>
import autoField from './item/field.vue'
import autoInput from './item/input.vue'
import autoSelect from './item/select.vue'
import { isNull } from '@/utils/tools.js'
export default {
  name: "auto-form",
  components: {
    autoField,
    autoInput,
    autoSelect
  },
  props: {
    package: {		//自动表单包
      type: Object,
      default () {
        return {}
      }
    },
    value: {
      type: Object
    }
  },
  data () {
    return {
      formdata: {},
      disabled: true,
      length: 0,
      judge: [],
      id: ""
    }
  },
  created () {
    this.judge = this.isDisabled()
  },
  methods: {
    getOutValue (value) {
      this.formdata = this.value
      this.id = this.value.id
      let data;
      for (var i in this.formdata) {
        if (value === i) {
          // console.log(this.formdata[i])
          data = this.formdata[i]
        }
      }
      // console.log("DATA",data)
      return data
      // console.log(this.formdata[value])
      // return this.formdata[value]
    },
    getValue (e) {
      // console.log(e)
      this.formdata[e.field] = e.value
      this.judge = this.isDisabled()
    },
    // 判断是否不可用
    isDisabled () {
      let that = this
      let n = [];
      // console.log(this.formdata,this.package.components[i].field)
      for (var i in this.package.components) {
        if (this.package.components[i].required) {
          n.push(isNull(this.formdata[this.package.components[i].field]))
          // console.log(that.package.components.length,Object.keys(that.formdata).length)
        }
      }
      return n
    },
    getJSON () {
      let isPass = true
      // console.log(this.judge)
      this.judge.map((item, i) => {
        if (item === false) {
          isPass = false
        }
      })
	  // uni.showModal({
	  // 	title: '提示',
	  // 	content: '这是一个模态弹窗',
	  // 	success: function (res) {
	  // 		if (res.confirm) {
	  // 			console.log('用户点击确定');
	  // 		} else if (res.cancel) {
	  // 			console.log('用户点击取消');
	  // 		}
	  // 	}
	  // });
      if (!isPass) {
        uni.showModal({
          title: "提交失败",
          showCancel: false
        })
        return;
      }
      console.log(this.id)
      if (isNull(this.id)) {
        this.$request(this.package.saveApi + `/${this.id}`, this.formdata, "put").then((res) => {
          // console.log(res)
          if (res.code === 200) {
            uni.showModal({
              title: "提交成功",
              showCancel: false,
              success (res) {
                if (res.confirm) {
                  uni.reLaunch({
                    url: "/pages/index/index"
                  })
                }
              }
            })
          } else {
            uni.showModal({
              title: "提交失败",
              showCancel: false
            })
          }

        }).catch(err => {
          uni.showModal({
            title: "提交失败",
            showCancel: false
          })
        })
      } else {
        // console.log(this.formdata)
        this.$request(this.package.saveApi, this.formdata, "post").then((res) => {
          // console.log(res)
          if (res.code === 200) {
            uni.showModal({
              title: "提交成功",
              showCancel: false,
              success (res) {
                if (res.confirm) {
                  uni.reLaunch({
                    url: "/pages/index/index"
                  })
                }
              }
            })
          } else {
            uni.showModal({
              title: "提交失败",
              showCancel: false
            })
          }

        }).catch(err => {
          uni.showModal({
            title: "提交失败",
            showCancel: false
          })
        })
      }

    }
  }
}
</script>

<style>
.auto_form {
  /* border: 1px solid #999; */
}
.auto_form_title {
  width: 100%;
  /* text-align: center; */
  font-size: 20px;
  font-weight: bolder;
  margin-bottom: 10px;
  background-color: #22a7f2;
  padding: 10px 0;
  color: white;
}
.auto_form_body {
  position: relative;
  left: 50%;
  transform: translate(-50%);
  margin-bottom: 60px;
}
.auto_form_button_box {
  width: 100%;
  position: fixed;
  bottom: 0;
  left: 0;
  /* margin: 50px auto 0; */
}
.auto_form_button {
  width: 100%;
  min-height: 50px;
  background-color: #22a7f2;
  color: white;
  border-radius: 0px;
  border: none;
  position: relative;
  left: 50%;
  transform: translate(-50%);
  font-size: 18px;
  font-weight: bolder;
  cursor: pointer;
}
</style>
