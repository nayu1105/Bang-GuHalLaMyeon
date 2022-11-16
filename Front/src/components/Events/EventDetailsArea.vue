<template>
  <div>
    <EventDetailsTitle />
    <section class="event__area pb-110">
      <div class="container">
        <div class="row">
          <div class="col-xxl-8 col-xl-8 col-lg-8">
            <div class="events__wrapper">
              <!-- <div class="events__thumb mb-35 w-img">
                <img src="../../assets/img/events/event-1.jpg" alt="" />
              </div> -->
              <div class="events__details mb-35">
                <h3>이벤트 Content</h3>
                <p>
                  He legged it up the kyver have it mush super me old mucker cheeky naff that are
                  you taking the piss, blow off down the pub bite your arm off the wireless boot cor
                  blimey guvnor happy days bender what a load of rubbish, say pardon me horse play
                  spiffing Why car boot gosh bubble and squeak. Cheers Richard bugger show off show
                  off pick your nose and blow off get stuffed mate chancer in my flat loo, bevvy
                  amongst hunky-dory bender bubble and squeak me old mucker vagabond, barmy spend a
                  penny chimney pot young delinquent bum bag the bee's knees chap, gosh nice one
                  knees up the wireless Charles such a fibber. Mush barmy bleeding Jeffrey pardon me
                  barney grub loo cup of tea bubble and squeak bugger all mate say, I bloke matie
                  boy tickety-boo give us a bell up the duff bugger lurgy wind up I don't want no
                  agro.
                </p>
              </div>
            </div>
          </div>
          <div class="col-xxl-4 col-xl-4 col-lg-4">
            <div class="events__sidebar pl-70">
              <div class="events__sidebar-widget white-bg mb-20">
                <div class="events__sidebar-shape">
                  <img
                    class="events-sidebar-img-2"
                    src="../../assets/img/events/event-shape-2.png"
                    alt=""
                  />
                  <img
                    class="events-sidebar-img-3"
                    src="../../assets/img/events/event-shape-3.png"
                    alt=""
                  />
                </div>
                <div class="events__info">
                  <!-- <div
                    class="events__info-meta mb-25 d-flex align-items-center justify-content-between"
                  >
                    <div class="events__info-price">
                      <h5>$76.<span>00</span></h5>
                      <h5 class="old-price">$142.00</h5>
                    </div>
                    <div class="events__info-discount">
                      <span>68% OFF</span>
                    </div>
                  </div> -->
                  <div class="events__info-content mb-35">
                    <div class="events__allow mb-40">
                      <h3>시간</h3>
                      <ul>
                        <li><i class="fal fa-check"></i> Business's managers, leaders</li>
                        <li>
                          <i class="fal fa-check"></i> Downloadable lectures, code and design assets
                          for all projects
                        </li>
                        <li>
                          <i class="fal fa-check"></i> Anyone who is finding a chance to get the
                          promotion
                        </li>
                      </ul>
                    </div>
                  </div>
                  <div class="events__join-btn">
                    <router-link to="/contact" class="e-btn e-btn-7 w-100"
                      >Enroll <i class="far fa-arrow-right"></i
                    ></router-link>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import EventDetailsTitle from '@/components/Events/EventDetailsTitle.vue';

export default {
  name: 'EventDetailsArea',
  components: {
    EventDetailsTitle,
  },
};
</script>
