<template>
  <LineChartGenerator
    :chart-options="chartOptions"
    :chart-data="chartData"
    :chart-id="chartId"
    :dataset-id-key="datasetIdKey"
    :plugins="plugins"
    :css-classes="cssClasses"
    :styles="styles"
    :width="width"
    :height="height"
  />
</template>

<script>
import { Line as LineChartGenerator } from "vue-chartjs/legacy";

import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  LineElement,
  LinearScale,
  CategoryScale,
  PointElement,
} from "chart.js";

ChartJS.register(Title, Tooltip, Legend, LineElement, LinearScale, CategoryScale, PointElement);

export default {
  name: "LineChart",
  components: {
    LineChartGenerator,
  },
  props: {
    chartId: {
      type: String,
      default: "line-chart",
    },
    datasetIdKey: {
      type: String,
      default: "label",
    },
    width: {
      type: Number,
      default: 400,
    },
    height: {
      type: Number,
      default: 400,
    },
    cssClasses: {
      default: "",
      type: String,
    },
    styles: {
      type: Object,
      default: () => {},
    },
    plugins: {
      type: Array,
      default: () => [],
    },
  },
  options: {
    scales: {
      xAxes: [
        {
          stacked: true,
          ticks: {
            fontColor: "black",
          },
        },
      ],
    },
  },
  data() {
    return {
      list: this.$store.state.house.houseDetailList.avgDealAmount,

      chartData: {
        labels: this.$store.state.house.listLabel,
        datasets: [
          {
            label: "평균 매매가",
            borderColor: "#f49d1a",
            backgroundColor: "#f49d1a",
            data: this.$store.state.house.listData,
          },
        ],
      },
      chartOptions: {
        responsive: true,
        maintainAspectRatio: false,
      },
    };
  },

  created() {
    this.makeData();
    ChartJS.destroy();
  },
  methods: {
    makeData() {
      this.$store.state.house.listLabel = [];
      this.$store.state.house.houseDetailList.avgDealAmount = [];

      let idx = 0;
      this.list.forEach((el) => {
        this.$store.state.house.listLabel[idx] = el.dealYear + "." + this.fillZero(el.dealMonth);
        this.$store.state.house.listData[idx] = el.avgDealAmount;
        idx++;
      });
    },
    fillZero(num) {
      let str = String(num);
      return str.padStart(2, "0");
    },
  },
};
</script>
