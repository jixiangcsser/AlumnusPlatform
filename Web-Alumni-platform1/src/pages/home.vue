<template>
<div>
    <headTop></headTop>
    <section class="data_section">
        <header class="section_title">数据统计</header>
        <el-row :gutter="20" style="margin-bottom: 20px;">
            <el-col :span="4">
                <div class="data_list today_head">
                    <span class="data_num head">当日数据：</span>
                </div>
            </el-col>
            <el-col :span="4">
                <div class="data_list">
                    <span class="data_num">{{userCount}}</span> 新增用户</div>
            </el-col>
            <el-col :span="4">
                <div class="data_list">
                    <span class="data_num">{{orderCount}}</span> 新增订单</div>
            </el-col>
            <el-col :span="4">
                <div class="data_list">
                    <span class="data_num">{{adminCount}}</span> 新增管理员</div>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="4">
                <div class="data_list all_head">
                    <span class="data_num head">总数据：</span>
                </div>
            </el-col>
            <el-col :span="4">
                <div class="data_list">
                    <span class="data_num">{{allUserCount}}</span> 注册用户</div>
            </el-col>
            <el-col :span="4">
                <div class="data_list">
                    <span class="data_num">{{allOrderCount}}</span> 订单</div>
            </el-col>
            <el-col :span="4">
                <div class="data_list">
                    <span class="data_num">{{allAdminCount}}</span> 管理员</div>
            </el-col>
        </el-row>
    </section>
    <div class="visitorpie">
        <div id="visitorpie" class="" style="width: 90%;height:450px;"></div>
    </div>
</div>
</template>

<script>
import headTop from "./header/headTop.vue";
export default {
  data() {
    return {
      userCount: 5,
      orderCount: 2,
      adminCount: 3,
      allUserCount: 2245,
      allOrderCount: 1000,
      allAdminCount: 12,
      pieData: {
        beijing: 561,
        shanghai: 679,
        shenzhen: 564,
        hangzhou: 187,
        qita: 137,
        guangzhou: 450
      }
    };
  },
  components: {
    headTop
  },
  mounted() {
    this.myChart = echarts.init(document.getElementById("visitorpie"));
    this.initData();
  },
  computed: {},
  methods: {
    initData() {
      const option = {
        title: {
          text: "科大软院校友分布图",
          subtext: "数据来源仅供参考",
          x: "center"
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
          orient: "vertical",
          left: "left",
          data: ["北京", "上海", "深圳", "杭州", "广州", "其他"]
        },
        series: [
          {
            name: "区域/人数/比例",
            type: "pie",
            radius: "55%",
            center: ["50%", "60%"],
            data: [
              { value: this.pieData.beijing, name: "北京" },
              { value: this.pieData.shanghai, name: "上海" },
              { value: this.pieData.shenzhen, name: "深圳" },
              { value: this.pieData.hangzhou, name: "杭州" },
              { value: this.pieData.guangzhou, name: "广州" },
              { value: this.pieData.qita, name: "其他" }
            ],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)"
              }
            }
          }
        ]
      };
      this.myChart.setOption(option);
    }
  }
};
</script>

<style lang="less">
@import "../style/mixin";
.data_section {
  padding: 20px;
  margin-bottom: 40px;
  .section_title {
    text-align: center;
    font-size: 30px;
    margin-bottom: 10px;
  }
  .data_list {
    text-align: center;
    font-size: 14px;
    color: #666;
    border-radius: 6px;
    background: #e5e9f2;
    .data_num {
      color: #333;
      font-size: 26px;
    }
    .head {
      border-radius: 6px;
      font-size: 22px;
      padding: 4px 0;
      color: #fff;
      display: inline-block;
    }
  }
  .today_head {
    background: #ff9800;
  }
  .all_head {
    background: #20a0ff;
  }
}
.wan {
  .sc(16px, #333);
}
.visitorpie {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}
</style>
